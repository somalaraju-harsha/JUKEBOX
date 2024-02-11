package com.crio.codingame.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.ContestStatus;
import com.crio.codingame.entities.RegisterationStatus;
import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.repositories.ContestRepository;
import com.crio.codingame.repositories.IContestRepository;
import com.crio.codingame.repositories.IUserRepository;
import com.crio.codingame.repositories.UserRepository;

public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IContestRepository contestRepository;

    public UserService(IUserRepository userRepository, IContestRepository contestRepository) {
        this.userRepository = userRepository;
        this.contestRepository = contestRepository;
    }
    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store User into the repository.
    int countUser=1;
    @Override
    public User create(String name) {
        User u=new User(""+countUser, name, 1500);
        countUser+=1;
     return userRepository.save(u);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Users in Ascending Order w.r.t scores if ScoreOrder ASC.
    // Or
    // Get All Users in Descending Order w.r.t scores if ScoreOrder DESC.

    @Override
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder){
        List<User> res=new ArrayList<>();
        for(User x:userRepository.findAll()){
            res.add(x);
        }
        if(scoreOrder.equals(scoreOrder.ASC)){
            Collections.sort(res,(a ,b)->{
                if(a.getScore()>b.getScore()){
                    return 1;
                }
                else if(a.getScore()<b.getScore()){
                    return -1;
                }
                else{
                    return 0;
                }
            });
        }
        else{
            Collections.sort(res,(a ,b)->{
                if(a.getScore()<b.getScore()){
                    return 1;
                }
                else if(a.getScore()>b.getScore()){
                    return -1;
                }
                else{
                    return 0;
                }
            });

        }
     return res;
    //  Collections.emptyList();
    }

    @Override
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(() -> new ContestNotFoundException("Cannot Attend Contest. Contest for given id:"+contestId+" not found!"));
        User user = userRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException("Cannot Attend Contest. User for given name:"+ userName+" not found!"));
        if(contest.getContestStatus().equals(ContestStatus.IN_PROGRESS)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is in progress!");
        }
        if(contest.getContestStatus().equals(ContestStatus.ENDED)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is ended!");
        }
        if(user.checkIfContestExists(contest)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is already registered!");
        }
        user.addContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(),RegisterationStatus.REGISTERED);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Withdraw the user from the contest
    // Hint :- Refer Unit Testcases withdrawContest method

    @Override
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
    //  Optional<Contest> op=contestRepository.findById(contestId);
    //  Optional<User> opu=userRepository.findByName(userName);
    //     if(op.isPresent()&&opu.isPresent()){
    //         if(op.get().getContestStatus()==ContestStatus.NOT_STARTED&&opu.get().getName().equals(userName)){
    //             opu.get().deleteContest(op.get());
    //         }
    //         else if(op.get().getContestStatus()==ContestStatus.IN_PROGRESS){
    //             throw new InvalidOperationException();
    //         }
    //         else if(op.get().getContestStatus()==ContestStatus.ENDED){
    //             throw new InvalidOperationException();
    //         }
    //         else if(op.get().getCreator().equals(userName)){
    //             throw new inva
          //  }
            // for(Contest x:contestRepository.findAll()){
            //     if(x.getContestStatus()==ContestStatus.NOT_STARTED&&x.getName().equals(userName)){
            //         for(User u:userRepository.findAll()){
            //             if(userName.equals(u.getName())){
            //                 u.deleteContest(x);
            //             }
            //         }
            //     }
            // }
     //   }
        // else if(!op.isPresent()){
        //     throw new ContestNotFoundException();
        // }
        // if(!opu.isPresent()){
        //     throw new UserNotFoundException();
        // }
        Contest contest= contestRepository.findById(contestId).orElseThrow(()->  new ContestNotFoundException("Cannot Withdraw Contest. Contest for given id:"+contestId+" not found!"));

        User user=userRepository.findByName(userName).orElseThrow(()-> new UserNotFoundException());



        if(!user.checkIfContestExists(contest) || contest.getContestStatus()!=ContestStatus.NOT_STARTED){
            throw new InvalidOperationException();
        }

        user.deleteContest(contest);
        userRepository.save(user);


        
        
     return new UserRegistrationDto(contest.getName(), userName, RegisterationStatus.NOT_REGISTERED);

      //  return null;
    }
    
}

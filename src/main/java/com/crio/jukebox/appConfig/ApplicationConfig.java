package com.crio.jukebox.appConfig;

import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreatePlayListCommand;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.DeletePlayListCommand;
import com.crio.jukebox.commands.LoadSongCommand;
import com.crio.jukebox.commands.ModifyPlayListCommand;
import com.crio.jukebox.commands.PlayPlayListCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.repositories.IPlayListRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.services.IPlayListService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.PlayListService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.UserService;

public class ApplicationConfig {

    private final IUserRepository userRepository=new UserRepository();
    private final IPlayListRepository playListRepository=new PlayListRepository();
    private final ISongRepository songRepository=new SongRepository();

    private final IUserService userService = new UserService(userRepository,playListRepository);
    private final ISongService songService = new SongService(songRepository);
    private final IPlayListService playListService = new PlayListService(playListRepository,songRepository);

    private final CreateUserCommand createUserCommand=new CreateUserCommand(userService);
    private final CreatePlayListCommand createPlayListCommand=new CreatePlayListCommand(playListService,songService);
    private final DeletePlayListCommand deletePlayListCommand=new DeletePlayListCommand(playListService);
    private final PlayPlayListCommand playPlayListCommand=new PlayPlayListCommand(playListService);
    private final ModifyPlayListCommand modifyPlayListCommand=new ModifyPlayListCommand(playListService);
    private final PlaySongCommand playSongCommand=new PlaySongCommand(playListService);
    private final LoadSongCommand loadSongCommand=new LoadSongCommand(songService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("CREATE-USER", createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST", createPlayListCommand);
        commandInvoker.register("DELETE-PLAYLIST", deletePlayListCommand);
        commandInvoker.register("PLAY-PLAYLIST", playPlayListCommand);
        commandInvoker.register("MODIFY-PLAYLIST", modifyPlayListCommand);
        commandInvoker.register("PLAY-SONG", playSongCommand);
        commandInvoker.register("LOAD-DATA", loadSongCommand);

        return commandInvoker;
    }
    
}

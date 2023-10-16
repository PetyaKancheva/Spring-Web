package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.DTO.UserLoginDTO;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements  UserService{



    public boolean loginUser(UserLoginDTO userLoginDTO) {
        //TODO
//        userLoginDTO.password();
//        userLoginDTO.username();
//        userRepository.findBy(User.)

        //get parameters user nmae and password
        //seaerch if exist in data base
        //true if exist if not send message wrong password or user
        return false;
    }

    public void registerUser(UserLoginDTO userLoginDTO) {

        //change DTO

    }
//    @Query(value = "SELECT * FROM user WHERE username=?", nativeQuery = true)
//    public User findByUsername(String username){
//        return userRepository.findBy(User, Query);
//    };


    private User map(UserLoginDTO userLoginDTO) {
        return new User().setUsername(userLoginDTO.username()).setPassword(userLoginDTO.password());
    }


    @Override
    public User findByUsername() {
        return null;
    }

    @Override
    public boolean loginUser() {
        return false;
    }

    @Override
    public void logoutUser() {

    }
}

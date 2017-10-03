package sg.edu.nus.iss.phoenix.user.android.controller;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.phoenix.core.android.controller.MainController;
import sg.edu.nus.iss.phoenix.user.android.delegate.AssignRoleDelegate;
import sg.edu.nus.iss.phoenix.user.android.delegate.CreateUserDelegate;
import sg.edu.nus.iss.phoenix.user.android.delegate.DeleteUserDelegate;
import sg.edu.nus.iss.phoenix.user.android.delegate.RetrieveUsersDelegate;
import sg.edu.nus.iss.phoenix.user.android.delegate.UpdateUserDelegate;
import sg.edu.nus.iss.phoenix.user.android.ui.MaintainUserScreen;
import sg.edu.nus.iss.phoenix.user.android.ui.SelectRoleScreen;
import sg.edu.nus.iss.phoenix.user.android.ui.UserListScreen;
import sg.edu.nus.iss.phoenix.user.entity.Role;
import sg.edu.nus.iss.phoenix.user.entity.User;


/**
 * @author sujit  ambore
 * @version 1.0
 */

public class UserController {
    private static final String TAG = UserController.class.getName();

    private UserListScreen userListScreen;
    private MaintainUserScreen maintainUserScreen;
    private SelectRoleScreen selectRoleScreen;
    private User us2edit = null;

    //Gcode
    private ArrayList<Role> roles;


    public void startUseCase() {
        us2edit = null;
        Intent intent = new Intent(MainController.getApp(), UserListScreen.class);
        MainController.displayScreen(intent);
    }
        public void roleUseCase() {
        Intent intent = new Intent(MainController.getApp(),SelectRoleScreen.class );
        MainController.displayScreen(intent);
    }

    public void onDisplayUserList(UserListScreen userListScreen) {
        this.userListScreen = userListScreen;
        new RetrieveUsersDelegate(this).execute("all");
    }

    public void userRetrieved(List<User> users) {
        userListScreen.showUsers(users);
    }

    public void selectCreateUser() {
        us2edit = null;
        //new CreateUserDelegate(this).execute();
        Intent intent = new Intent(MainController.getApp(), MaintainUserScreen.class);
        MainController.displayScreen(intent);
    }

    //Gcode
    public void selectCreateRole(User user) {
        roles = null;
        Intent intent = new Intent(MainController.getApp(), SelectRoleScreen.class);
        MainController.displayScreen(intent);}
    public void rolesSelected(ArrayList<Integer> roles){
        us2edit.setRoleId(roles);
        new AssignRoleDelegate(this).execute(us2edit);}

    /* selectEditUser enables editing user name and refresh back to userlist screen*/
    public void selectEditUser(User users) {
        us2edit = users;
        Log.v(TAG, "Editing user name: " + users.getName() + "...");
        Intent intent = new Intent(MainController.getApp(), MaintainUserScreen.class);
        MainController.displayScreen(intent);
    }

    public void onDisplayUser(MaintainUserScreen maintainUserScreen) {
        this.maintainUserScreen = maintainUserScreen;
        if (us2edit == null)
            maintainUserScreen.createUser();
        else
            maintainUserScreen.editUser(us2edit);
    }

    public void selectUpdateUser(User us) { new UpdateUserDelegate(this).execute(us);}

    public void selectDeleteUser(User us) { new DeleteUserDelegate(this).execute(String.valueOf(us.getUserId()));}

    public void userDeleted(boolean success) {
        /* Go back to UserList screen with refreshed users.*/
        startUseCase(); }

    public void userUpdated(boolean success) {
        /* Go back to UserList screen with refreshed users. */
        startUseCase(); }


    public void selectCreateUser(User user) {
        us2edit= user;
        new CreateUserDelegate(this).execute(user);
    }


    //gcode
    public void userCreated(int createdUserIdIn) {us2edit.setUserId(createdUserIdIn);
        selectCreateRole(us2edit);
    }

    //old code
//    public void userCreated(boolean success) {
//        // Go back to UserList screen with refreshed users.
//        startUseCase(); }

    public void selectCancelCreateEditUser() {
        // Go back to UserList screen with refreshed users.
        startUseCase();}

//  Old code
//    public void maintainedUser() {
//        ControlFactory.getUserController().maintainedUser();
//    }

    //gcode
    public void onDisplayRole(SelectRoleScreen selectRoleScreen) {
        this.selectRoleScreen = selectRoleScreen;}

    //gcode
    public void roleAssigned(boolean success) {
        startUseCase();}


}

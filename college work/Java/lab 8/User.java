

public class User {

    
        String userName;
        String userId;
        int userAge;
        String password;
        String role;
    
        User(String userName, String UserId, int userAge, String password, String role) {
            this.userName = userName;
            this.userId = UserId;
            this.userAge = userAge;
            this.password = password;
            this.role = role;
        }//end constructor

        public boolean login(String userId, String password) {
            return this.userId.equals(userId) && this.password.equals(password);
        }
    
        public String getRole() {
            return role;
        }
    }


        
    
    
    


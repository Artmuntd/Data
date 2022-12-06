public class Data {
    private static  final  String VALID_CHARTERES = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789_";
    private  Data(){

    }
    public  static  boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login,password,confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
        return  true;

    }
   private   static  void check(String login, String password, String confirmPassword) throws  WrongLoginExeption, WrongPasswordExeption{
        if(!validate(login)){
            throw  new WrongLoginExeption("Логин невалиден!");
        }
       if(!validate(password)){
           throw  new WrongPasswordExeption("Пароль невалиден!");
       }
       if(!password.equals(confirmPassword)){
           throw  new WrongPasswordExeption("Пароль не совпадает!");
       }

   }
   private  static boolean validate(String s){
        if(s.length()>20){
            return false;
        }
        for ( int i = 0; i< s.length(); i++){
            if(!VALID_CHARTERES.contains(String.valueOf(s.charAt(i)))){
                return false;
            }
        }
        return true;
   }
}

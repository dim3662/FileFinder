package PoiskManager;


public class PoiskForStart extends MorePoisk {
    public boolean Equals(String fileName, String Extencion) {
        String[] fileNameSplit = fileName.split("\\.");
        String strok = "";
        if(fileNameSplit.length>1) {
            for (int i = 0; i < fileNameSplit.length - 1; i++) {
                strok += fileNameSplit[i];
                if (i != fileNameSplit.length - 2) strok += ".";
            }
        }
        else {
            strok=fileName;
    }
        if (strok.equals(Extencion))
            return true;
        else return false;
    }
}

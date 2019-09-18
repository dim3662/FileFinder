package PoiskManager;


public class PoiskForExtencion extends MorePoisk {
    public boolean Equals(String fileName, String Extencion) {
        String[] fileNameSplit = fileName.split("\\.");
        if ((fileNameSplit[fileNameSplit.length - 1].equals(Extencion)) && (fileNameSplit.length>1))
            return true;
        else return false;
    }
}

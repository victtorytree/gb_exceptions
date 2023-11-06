public class dz {
    public static void main(String[] args) {
        Handler hdl = new Handler();
        String res = hdl.entryData();
        hdl.writeFile(res);
    }
}

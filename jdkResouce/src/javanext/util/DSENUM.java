package javanext.util;

public enum DSENUM {

    ds1("科目表FUNCODE","TAIKANG","1222"),
    ds2("科目表FUNCODE","ZGRS","9005"),
    ds3("风险提示函FUNCODE","ZGRS","1222");

    private String funcode = "";
    private String orgcode = "";
    private String dscode = "";

    DSENUM(String funcode, String orgcode, String dscode) {
        this.funcode = funcode;
        this.orgcode = orgcode;
        this.dscode = dscode;
    }

    public static String getFunCodeByDsCode(String orgcode,String dscode) {
        for (DSENUM causeEnum : DSENUM.values()) {
            if (causeEnum.orgcode.equals(orgcode) && causeEnum.dscode.equals(dscode)){
                return causeEnum.funcode;
            }
        }
        return null;
    }
}

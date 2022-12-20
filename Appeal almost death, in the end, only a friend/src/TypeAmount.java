public class TypeAmount {
    private int desertedArea,
            defectiveArea,
            illegalArea,
            mischief,
            trafficOffenders,
            nonStandardProducts,
            fraud,
            other;
    
    public TypeAmount(){this(0,0,0,0,0,0,0,0);}
    public TypeAmount(int dsa,int dfa,int iga,int mis,int tfo,int nsp,int frd,int oth){
        this.desertedArea = dsa;
        this.defectiveArea = dfa;
        this.illegalArea = iga;
        this.mischief = mis;
        this.trafficOffenders = tfo;
        this.nonStandardProducts = nsp;
        this.fraud = frd;
        this.other = oth;
    }
    
    public int getDSA(){return this.desertedArea;}
    public int getDFA(){return this.defectiveArea;}
    public int getIGA(){return this.illegalArea;}
    public int getMIS(){return this.mischief;}
    public int getTFO(){return this.trafficOffenders;}
    public int getNSP(){return this.nonStandardProducts;}
    public int getFRD(){return this.fraud;}
    public int getOTH(){return this.other;}
}

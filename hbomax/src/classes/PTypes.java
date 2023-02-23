/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author isaac
 */
public class PTypes {
    static public String intro = "intro";
    static public String credit = "credit";
    static public String start = "start";
    static public String end = "end";
    static public String twist = "twist";
    static public String assembler = "assembler";
    static public String noType = "noType";
    static public String chapter = "chapter";
    
    
        public static String getChapterPartByOrder(int position){
        switch (position) {
            case 0:
                return PTypes.intro;
            case 1:
                return PTypes.start;
            case 2:
                return PTypes.credit;
            case 3:
                return PTypes.twist;
            case 4:
                return PTypes.end;
            case 5:
                return PTypes.chapter;
            default:
                return PTypes.noType;
        }
    }
     /**
     * Class that defines constants for producer type
     */
//    public PTypes (){
//        this.intro = "intro";
//        this.credit = "credit";
//        this.start = "start";
//        this.end = "end";
//        this.twist = "twist";
//        this.assembler = "assembler";
//    }
}

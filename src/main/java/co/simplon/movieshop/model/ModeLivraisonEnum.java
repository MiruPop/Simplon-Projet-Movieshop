package co.simplon.movieshop.model;

public enum ModeLivraisonEnum {
    A_DOMICILE("Livraison à domicile"),
    RELAY("Livraison en point relay");

    private String modeLivraison;

    ModeLivraisonEnum(String modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public String toString(){
        return modeLivraison;
    }

    public static String getModeLivraison(String code) {
        for(ModeLivraisonEnum e : ModeLivraisonEnum.values()) {
            if ((e.modeLivraison.equals(code)))
                return e.modeLivraison;
        }
        return null;
    }
}

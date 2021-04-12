import java.util.*;

public class Epulet {
    private Pozicio startPozicio;
    private Pozicio[] bunozok;
    private Pozicio[] falak;
    private Pozicio[] konyvespolcok;
    private Pozicio[] asztalok;
    private Pozicio[] ajtok;

    private List<Pozicio> bunozoLista = new LinkedList<>();
    private List<Pozicio> akadalyLista = new LinkedList<>();
    private List<Pozicio> ajtoLista = new LinkedList<>();

    private void inicializal() {
        bunozoLista.addAll(Arrays.asList(bunozok));
        akadalyLista.addAll(Arrays.asList(falak));
        akadalyLista.addAll(Arrays.asList(konyvespolcok));
        akadalyLista.addAll(Arrays.asList(asztalok));
        ajtoLista.addAll(Arrays.asList(ajtok));
    }

    private int eliminal(List<Pozicio> keresendoLista) {
        Set<Pozicio> vizsgalando = new HashSet<>();
        vizsgalando.add(startPozicio);
        int koltseg = 0;
        while(true) {
            vizsgalando = kifejt(vizsgalando);
            koltseg++;

            Pozicio megtalaltElem = null;
            kulso: for (Pozicio keresendo: keresendoLista) {
                for (Pozicio p: vizsgalando) {
                    if (keresendo.equals(p)) {
                        megtalaltElem = keresendo;
                        break kulso;
                    }
                }
            }
            if (megtalaltElem != null) {
                keresendoLista.remove(megtalaltElem);
                startPozicio = megtalaltElem;
                break;
            }
        }
        return koltseg;
    }

    private Set<Pozicio> kifejt(Set<Pozicio> halmaz) {
        Set<Pozicio> ujHalmaz = new HashSet<>();

        for (Pozicio p: halmaz) {
            Pozicio p1 = new Pozicio(p.x-1, p.y);
            Pozicio p2 = new Pozicio(p.x+1, p.y);
            Pozicio p3 = new Pozicio(p.x, p.y-1);
            Pozicio p4 = new Pozicio(p.x, p.y+1);

            if(!akadalyLista.contains(p1)){
                ujHalmaz.add(p1);
            }

            if(!akadalyLista.contains(p2)){
                ujHalmaz.add(p2);
            }

            if(!akadalyLista.contains(p3)) {
                ujHalmaz.add(p3);
            }
            if(!akadalyLista.contains(p4)){
                ujHalmaz.add(p4);
            }
        }
        return ujHalmaz;
    }

    public int lepesekSzama() {
        inicializal();

        int osszkoltseg = 0;
        while (bunozoLista.size() != 0) {
            osszkoltseg += eliminal(bunozoLista);
        }

        if (ajtoLista.contains(startPozicio)) {
            return osszkoltseg + 1;
        }
        osszkoltseg += eliminal(ajtoLista);
        return osszkoltseg + 1;
    }


    public Epulet(Pozicio startPozicio, Pozicio[] bunozok, Pozicio[] falak, Pozicio[] konyvespolcok, Pozicio[] asztalok, Pozicio[] ajtok) {
        this.startPozicio = startPozicio;
        this.bunozok = bunozok;
        this.falak = falak;
        this.konyvespolcok = konyvespolcok;
        this.asztalok = asztalok;
        this.ajtok = ajtok;
    }

}

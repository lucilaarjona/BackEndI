public class FacadeBusqueda {
    private AppHotel appHotel;
    private AppVuelo appVuelo;

    public FacadeBusqueda(AppHotel appHotel, AppVuelo appVuelo) {
        this.appHotel = appHotel;
        this.appVuelo = appVuelo;
    }
    public boolean busqueda(Hotel hotel, Vuelo vuelo){
        Boolean busquedas = false ;
        busquedas = busquedas + appHotel.busqueda(hotel);
        busquedas = busquedas + appVuelo.busqueda(vuelo);
        return busquedas;

    }
}

package demofacturas.mapper;

public interface IMapper <I, O>{
    public O map(I in);
    public O hidrate(I in, O out);
}

package be.vdab;

public class RepositoryException extends RuntimeException {
    public RepositoryException(Exception oorzaak) {
        super(oorzaak);
    }
}

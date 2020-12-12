package brojas;
import brojas.dao.ClienteDao;
import brojas.dao.CocheDao;
import brojas.dao.RevisionDao;
import brojas.model.Cliente;
import brojas.model.Coche;
import brojas.model.Revision;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CLIENTES

        Cliente lucas = new Cliente("4575","Lucas Vargas", "La Paz", "Av.Ayacucho s/n", 85987452);
        Cliente Carlos = new Cliente("2548","Carlos Perez", "Oruro", "Av.Bolivar s/n", 44589621);
        Cliente Lorena = new Cliente("4561-l","Lorena Quiroga", "Beni", "Av.Patria 32", 44554511);
        Cliente Luis = new Cliente("7845","Dorian Alcocer", "Tarija", "Av. Ayacuho", 44482136);

        //CRUD tabla cliente
        ClienteDao newClienteDao = new ClienteDao();

        //CREATE
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.addCliente(Carlos);
        clienteDao.addCliente(Lorena);
        clienteDao.addCliente(Luis);


        //READ
        List<Cliente> clientes = clienteDao.getAllCliente();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            System.out.println(cliente);
        }

        //UPDATE
        Cliente cliente = new Cliente("40415","Cristian Rojas", "Cochabamba", "Av.6 de Agosto", 784654122);
        clienteDao.updateCLiente(cliente);

        //DELETE
        clienteDao.deleteCLiente("2547");
        clienteDao.deleteCLiente("7845");


        //COCHES

        Coche SUSUKI1 = new Coche("15JU", "SUSUKI", "2000", "BLANCO", 10.000, new Cliente());
        Coche TOYOTA = new Coche("78K8", "TOYOTA", "precio", "AZUL", 12.000, new Cliente());
        Coche WOLSKVAGEN = new Coche("2HJK", "WOLSKVAGEN", "precio", "AMARILLO", 10.500, new Cliente());
        Coche YAMAHA = new Coche("65GT", "YAMAHA", "precio", "PLOMO", 13.000, new Cliente());
        Coche MITSUBISHI = new Coche("00H0", "MITSUBISHI", "NEGRO", "f", 60.000, new Cliente());

        //CRUD tabla cliente
        CocheDao newCocheDao = new CocheDao();

        //CREATE
        CocheDao cocheDao = new CocheDao();

        cocheDao.addCoche(SUSUKI1);
        cocheDao.addCoche(TOYOTA);
        cocheDao.addCoche(WOLSKVAGEN);
        cocheDao.addCoche(YAMAHA);
        cocheDao.addCoche(MITSUBISHI);

        //READ
        List<Coche> coches = cocheDao.getAllCoche();
        for (int i = 0; i < coches.size(); i++) {
            Coche coche = coches.get(i);

            System.out.println(coche);
        }

        //UPDATE
        Coche coche = new Coche("15GT", "SUSUKI", "2000", "BLANCO", 10.000, new Cliente());
        cocheDao.updteCoche(coche);

        //DELETE
        cocheDao.deleteCoche("15GT");
        cocheDao.deleteCoche("89h6");


        //REVISION
        Revision revision1 = new Revision("1558H", "SI", "NO", "NULL", new Coche());
        Revision revision2 = new Revision("48K5", "NO", "SI", "SI", new Coche());
        Revision revision3 = new Revision("00K0", "NO", "NO", "NULL", new Coche());
        Revision revision4 = new Revision("156K", "SI", "SI", "NO", new Coche());
        Revision revision5 = new Revision("15K8", "NO", "SI", "NO", new Coche());

        //CRUD tabla cliente
        RevisionDao newRevisionDao = new RevisionDao();

        //CREATE
        RevisionDao revisionDao = new RevisionDao();
        revisionDao.addRevision(revision1);
        revisionDao.addRevision(revision2);
        revisionDao.addRevision(revision3);
        revisionDao.addRevision(revision4);
        revisionDao.addRevision(revision5);

        //READ
        List<Revision> revisions = revisionDao.getAllRevision();
        for (int i = 0; i < revisions.size(); i++) {
            Revision revision =revisions.get(i);

            System.out.println(revision);
        }

        //UPDATE
        Revision revision = new Revision ("1558H", "SI", "NO", "NULL", new Coche());
        revisionDao.updateRevision(revision1);

        //DELETE
        revisionDao.deleteRevision("1558H");
        revisionDao.deleteRevision("03KI");
    }
}
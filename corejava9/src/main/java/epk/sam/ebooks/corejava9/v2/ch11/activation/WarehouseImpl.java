package epk.sam.ebooks.corejava9.v2.ch11.activation;

import java.io.*;
import java.rmi.*;
import java.rmi.activation.*;
import java.util.*;

/**
 * This class is the implementation for the remote Warehouse interface.
 * 
 * @version 1.0 2007-10-20
 * @author Cay Horstmann
 */
public class WarehouseImpl extends Activatable implements Warehouse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3961280726612614208L;
	private Map<String, Double> prices;

	public WarehouseImpl(ActivationID id,
			MarshalledObject<Map<String, Double>> param)
			throws RemoteException, ClassNotFoundException, IOException {
		super(id, 0);
		prices = param.get();
		System.out.println("Warehouse implementation constructed.");
	}

	public double getPrice(String description) throws RemoteException {
		Double price = prices.get(description);
		return price == null ? 0 : price;
	}
}

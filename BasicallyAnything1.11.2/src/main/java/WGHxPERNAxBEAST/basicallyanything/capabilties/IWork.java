package WGHxPERNAxBEAST.basicallyanything.capabilties;

public interface IWork {

	/**
	 * Return the current work that has been done
	 * 
	 * @return the current work that has been done
	 */
	int getWorkDone();

	/**
	 * Return the maximum amount of work the {@link TileEntity} can do
	 * 
	 * @return the maximum value for the "cooldown"
	 */
	int getMaxWork();

	/**
	 * Called when every tick by the {@link TileEntity} Typically will update
	 * the "cooldown" value
	 */
	void doWork();

	/**
	 * Called when the work has been completed i.e. when the cooldown has reset
	 */
	void workDone();

}
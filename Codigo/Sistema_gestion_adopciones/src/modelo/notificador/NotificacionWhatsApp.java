package modelo.notificador;

public class NotificacionWhatsApp implements IEstrategiaNotificacion{

	private IAdapterNotificacionWhatsApp adapter;
	
		
	public NotificacionWhatsApp(IAdapterNotificacionWhatsApp adapter) {
		this.adapter = adapter;
	}

	@Override
	public void enviar(Notificacion notificacion) {
		this.adapter.enviarWhatsApp(notificacion);
		
	}

	
}

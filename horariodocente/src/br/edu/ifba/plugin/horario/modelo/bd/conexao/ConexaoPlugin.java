package br.edu.ifba.plugin.horario.modelo.bd.conexao;


public class ConexaoPlugin extends ConexaoBD {

	private static String BDPLUGIN = "plugin";

	private static ConexaoPlugin instancia = null;

	public static ConexaoPlugin getInstancia() {
		if (instancia == null) {
			instancia = new ConexaoPlugin();
			instancia.iniciar(BDPLUGIN);
		}

		return instancia;
	}

	private ConexaoPlugin() {
	}

}
package com.azienda.webapp.utilities;


public class Utilities {
	// Regex solo literals e spazi
	public static boolean checkNomeCognome(String stringa) {
		return stringa.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$") && stringa != null;
	}

	// Regex email
	public static boolean checkEmail(String email) {
		return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") && email != null;
	}

	// Regex password lunghezza > 8, almeno 1 carattere speciale, almeno 1 numero,
	// almeno 1 maiuscola
	public static boolean checkPassword(String password) {
		return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})") && password != null;
	}

	/*
	private static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static String scriviSuFile(final Part part, String path) {
		
		String fileName = getFileName(part);
		try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
				InputStream fileContent = part.getInputStream();) {

			
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = fileContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			return fileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	} */
}

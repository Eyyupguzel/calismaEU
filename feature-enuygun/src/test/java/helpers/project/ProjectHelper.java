package helpers.project;


import helpers.base.IniHelper;
import helpers.base.Logger;



public class ProjectHelper {
    public org.apache.log4j.Logger logger = Logger.getLogger(Logger.class);
    private final IniHelper iniHelper;

    public ProjectHelper(IniHelper iniHelper) {
        this.iniHelper = iniHelper;
    }

    /**
     * Veriyi veri deposuna (INI dosyasına) yerleştiren yöntem.
     *
     * @param key   Veri deposunda kullanılacak anahtar
     * @param value Veri deposuna yerleştirilecek değer
     * @throws Exception İşlem sırasında bir hata oluştuğunda fırlatılır
     */
    public void putDataStore(String key, Object value) throws Exception {
        try {
            String stringValue = value.toString();
            iniHelper.writeIniFile(key, stringValue);
        } catch (Exception e) {
            logger.error("The method causing the error : ProjectHelper - putDataStore");
            throw new Exception(e.getMessage());
        }
    }


}

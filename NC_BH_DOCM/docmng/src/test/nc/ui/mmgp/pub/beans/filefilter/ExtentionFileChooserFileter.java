package nc.ui.mmgp.pub.beans.filefilter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * <b> ������չ�������ļ� </b>
 * <p>
 * ��ϸ��������
 * </p>
 * ��������:2011-3-26
 * 
 * @author wangweiu
 */
public class ExtentionFileChooserFileter extends FileFilter {
    private String extension = null;

    private String description = null;

    public ExtentionFileChooserFileter(String inExtention) {
        extension = inExtention;
    }

    public ExtentionFileChooserFileter(String inExtention,
                                       String inDescription) {
        extension = inExtention;
        description = inDescription;
    }

    /**
     * ��Ҫ˵��
     * 
     * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
     */
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        if (extension == null) {
            return false;
        }
        if (f.getAbsoluteFile().getName().toLowerCase().endsWith("." + extension.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * ��Ҫ˵��
     * 
     * @see javax.swing.filechooser.FileFilter#getDescription()
     */
    @Override
    public String getDescription() {
        if (description == null) {
            return extension.toUpperCase();
        }
        return description;
    }

    public String getExtension() {
        return extension;
    }

}

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;


public class CloseEditorsToTheRight extends AnAction implements DumbAware {
    public void actionPerformed(AnActionEvent e) {
        final EditorWindow window = e.getData(EditorWindow.DATA_KEY);
        if (window != null){
            VirtualFile[] tabs = window.getFiles();
            VirtualFile current = e.getData(CommonDataKeys.VIRTUAL_FILE);
            boolean foundCurrent = false;
            for (VirtualFile tab : tabs) {
                if (foundCurrent) {
                    window.closeFile(tab);
                }
                if (tab.equals(current)) {
                    foundCurrent = true;
                }
            }
        }
    }
}

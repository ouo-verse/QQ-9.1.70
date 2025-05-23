package s4;

import android.content.ContentValues;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends com.qzone.component.cache.database.a {
    public boolean descvisible = false;
    public boolean allSelectedStatus = false;
    public String poiName = null;
    public String poiAddress = null;
    public boolean poivisible = false;
    public boolean isChecked = false;
    public int selectedIndex = -1;
    public boolean timevisible = false;
    public boolean batchvisible = false;
    public String shareUploadContent = null;
    public List<Long> uploadUinList = null;
    public int index = 0;
    public int titleStartIndex = 0;
    public int numbersOfColumn = 0;
    public int group = 0;
    public int groupNum = 0;
    public int beginIndex = 0;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
    }
}

package uk;

import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\f\u00a8\u0006("}, d2 = {"Luk/c;", "Luk/b;", "Landroid/content/Intent;", "intent", "", "g2", "", "D", "I", "c2", "()I", "setMaxPhotoCount", "(I)V", "maxPhotoCount", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "e2", "()Ljava/util/ArrayList;", "setSelectedPics", "(Ljava/util/ArrayList;)V", "selectedPics", "", UserInfo.SEX_FEMALE, "Z", "f2", "()Z", "setNumberCheckBox", "(Z)V", "isNumberCheckBox", "G", "d2", "setPageMode", "pageMode", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends b {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isNumberCheckBox;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxPhotoCount = 50;

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<String> selectedPics = new ArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    private int pageMode = 1;

    /* renamed from: c2, reason: from getter */
    public final int getMaxPhotoCount() {
        return this.maxPhotoCount;
    }

    /* renamed from: d2, reason: from getter */
    public final int getPageMode() {
        return this.pageMode;
    }

    public final ArrayList<String> e2() {
        return this.selectedPics;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getIsNumberCheckBox() {
        return this.isNumberCheckBox;
    }

    public final void g2(Intent intent) {
        if (intent == null) {
            return;
        }
        this.maxPhotoCount = intent.getIntExtra(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(PictureConst.KEY_SELECTED_PHOTO_LLOC);
        if (stringArrayListExtra == null) {
            stringArrayListExtra = new ArrayList<>();
        }
        this.selectedPics = stringArrayListExtra;
        this.isNumberCheckBox = intent.getBooleanExtra(PictureConst.KEY_CHECKBOX_WITH_NUMBER, false);
        this.pageMode = intent.getIntExtra(PictureConst.KEY_PAGE_MODE, 1);
    }
}

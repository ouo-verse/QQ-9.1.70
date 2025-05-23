package u53;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class j extends MutableLiveData<List<MetaCategory>> {

    /* renamed from: d, reason: collision with root package name */
    public final MaterialType f438434d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f438435a;

        static {
            int[] iArr = new int[MaterialType.values().length];
            f438435a = iArr;
            try {
                iArr[MaterialType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f438435a[MaterialType.STICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f438435a[MaterialType.LYRIC_STICKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f438435a[MaterialType.AUTO_TEMPLATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f438435a[MaterialType.FIRST_TEMPLATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f438435a[MaterialType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f438435a[MaterialType.SPECIAL_EFFECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f438435a[MaterialType.PICK_ONLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f438435a[MaterialType.DAILY_SIGN_MOOD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f438435a[MaterialType.DAILY_SIGN_MUSIC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f438435a[MaterialType.DAILY_SIGN_BACKGROUND.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f438435a[MaterialType.PIC_RECOMMEND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f438435a[MaterialType.PIC_RECOMMEND_USER_PUBLISHED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f438435a[MaterialType.COVER_TEMPLATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f438435a[MaterialType.QZONE_MAGIC_STUDIO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f438435a[MaterialType.MAGIC_AVATAR.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f438435a[MaterialType.IMAGE_TEMPLATE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f438435a[MaterialType.TEXT_FONT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public j(MaterialType materialType) {
        this.f438434d = materialType;
    }

    private void c() {
        w53.b.a("WinkMaterialLiveData", "loadMaterialListAsync " + this.f438434d);
        switch (a.f438435a[this.f438434d.ordinal()]) {
            case 1:
                WinkEditorResourceManager.a1().V2();
                return;
            case 2:
                WinkEditorResourceManager.a1().j3();
                return;
            case 3:
                WinkEditorResourceManager.a1().Y2();
                return;
            case 4:
                WinkEditorResourceManager.a1().p3();
                return;
            case 5:
                WinkEditorResourceManager.a1().W2();
                return;
            case 6:
                WinkEditorResourceManager.a1().l3();
                return;
            case 7:
                WinkEditorResourceManager.a1().U2();
                return;
            case 8:
                WinkEditorResourceManager.a1().e3();
                return;
            case 9:
                WinkEditorResourceManager.a1().Q2("mood");
                return;
            case 10:
                WinkEditorResourceManager.a1().Q2("music");
                return;
            case 11:
                WinkEditorResourceManager.a1().Q2("background");
                return;
            case 12:
                WinkEditorResourceManager.a1().d3();
                return;
            case 13:
                WinkEditorResourceManager.a1().o3();
                return;
            case 14:
                WinkEditorResourceManager.a1().P2();
                return;
            case 15:
                WinkEditorResourceManager.a1().g3();
                return;
            case 16:
                WinkEditorResourceManager.a1().Z2();
                return;
            case 17:
                WinkEditorResourceManager.a1().f3();
                return;
            case 18:
                WinkEditorResourceManager.a1().m3();
                return;
            default:
                return;
        }
    }

    private void e() {
        postValue(Collections.emptyList());
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void postValue(List<MetaCategory> list) {
        super.postValue(list);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void setValue(List<MetaCategory> list) {
        w53.b.a("WinkMaterialLiveData", "setValue " + this.f438434d);
        super.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        w53.b.a("WinkMaterialLiveData", "onActive " + this.f438434d);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        w53.b.a("WinkMaterialLiveData", "onInactive " + this.f438434d);
        e();
    }
}

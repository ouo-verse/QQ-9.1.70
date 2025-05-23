package t44;

import android.content.Context;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f435386a;

    /* renamed from: b, reason: collision with root package name */
    private QUIListItemAdapter f435387b;

    /* renamed from: c, reason: collision with root package name */
    private Group f435388c;

    public a(Context context) {
        this.f435386a = context;
    }

    protected abstract Group a();

    public Group b(QUIListItemAdapter qUIListItemAdapter) {
        this.f435387b = qUIListItemAdapter;
        Group a16 = a();
        this.f435388c = a16;
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context c() {
        return this.f435386a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QUIListItemAdapter d() {
        return this.f435387b;
    }

    public void e() {
    }
}

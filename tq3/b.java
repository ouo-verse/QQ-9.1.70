package tq3;

import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.publish.ui.publishmodule.c;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends c {
    public b(PhotoActivity photoActivity) {
        super(photoActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.ui.publishmodule.c
    public void e() {
        super.e();
        ArrayList arrayList = new ArrayList();
        this.f51996a = arrayList;
        arrayList.add(new a());
        for (com.qzone.publish.ui.publishmodule.b bVar : this.f51996a) {
            bVar.r(this.f51997b);
            bVar.s(this);
        }
    }
}

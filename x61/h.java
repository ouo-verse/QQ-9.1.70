package x61;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends com.tencent.mobileqq.activity.aio.stickerrecommended.a {
    public h(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
    }

    private static boolean d(List<String> list, String str) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.a, com.tencent.mobileqq.activity.aio.stickerrecommended.d
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        return true;
    }

    public List<g> c(String str, a aVar, p pVar) {
        List<f> list;
        ArrayList arrayList = null;
        if (aVar != null && aVar.f447281a && (list = aVar.f447283c) != null && list.size() != 0) {
            arrayList = new ArrayList();
            for (f fVar : list) {
                if (d(fVar.f447293a, str)) {
                    new e().i(this.f179902a, pVar, str);
                    List<d> list2 = fVar.f447294b;
                    if (list2 != null && list2.size() > 0) {
                        Iterator<d> it = fVar.f447294b.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new g(it.next(), pVar, str));
                        }
                    }
                }
            }
            if (aVar.f447282b == 1) {
                Collections.shuffle(arrayList);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List<g> b(String str, p pVar) {
        return c(str, b.a(this.f179902a.getApp(), this.f179902a.getCurrentUin()), pVar);
    }
}

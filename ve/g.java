package ve;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.part.am;
import com.qzone.reborn.feedx.part.bb;
import com.qzone.reborn.feedx.part.bg;
import com.qzone.reborn.feedx.part.cb;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.feedx.part.moodlist.QZoneMoodListMemorySealPart;
import com.qzone.reborn.feedx.part.o;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends j {
    @Override // ve.j
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.feedx.part.moodlist.g());
        arrayList.add(new bg());
        arrayList.add(new am());
        if (iVar.d() == LoginData.getInstance().getUin()) {
            arrayList.add(new QZoneMoodListMemorySealPart());
            arrayList.add(new com.qzone.reborn.feedx.part.moodlist.c());
        } else {
            arrayList.add(new o());
        }
        arrayList.add(new cb());
        arrayList.add(new cc("page_launch_mood_list"));
        if (bb.INSTANCE.a()) {
            arrayList.add(new bb());
        }
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        return arrayList;
    }
}

package uw3;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"", "", "favoritePanelAniStickerOrderList", "Lcom/tencent/mobileqq/data/CustomEmotionData;", "a", "emotion_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    @Nullable
    public static final List<CustomEmotionData> a(@Nullable List<Integer> list) {
        boolean z16;
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                CustomEmotionData customEmotionData = new CustomEmotionData();
                customEmotionData.isLottieEmoji = true;
                customEmotionData.eId = String.valueOf(intValue);
                customEmotionData.emoPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, intValue);
                customEmotionData.RomaingType = "isUpdate";
                customEmotionData.emoId = Integer.MAX_VALUE;
                customEmotionData.resid = String.valueOf(intValue);
                arrayList.add(customEmotionData);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgExt", 1, "[getFavoritePanelAniStickerDataList] resultList=" + arrayList);
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.e("FavLottieEmoticonConfig", 1, "[getFavoritePanelAniStickerDataList] error! ", th5);
            return null;
        }
    }
}

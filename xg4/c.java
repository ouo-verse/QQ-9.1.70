package xg4;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.emo.data.HotPicEmoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$TimiEmoData;
import trpc.yes.common.MessageOuterClass$TimiPkgEmoticonData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lxg4/k;", "Ltrpc/yes/common/MessageOuterClass$TimiEmoData;", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {
    @NotNull
    public static final MessageOuterClass$TimiEmoData a(@NotNull k kVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        MessageOuterClass$TimiEmoData messageOuterClass$TimiEmoData = new MessageOuterClass$TimiEmoData();
        EmoticonInfo qqEmoInfo = kVar.getQqEmoInfo();
        boolean z17 = true;
        String str = "";
        if (qqEmoInfo instanceof IFavoriteEmoticonInfo) {
            PBStringField pBStringField = messageOuterClass$TimiEmoData.eId;
            String eid = ((IFavoriteEmoticonInfo) kVar.getQqEmoInfo()).getEid();
            if (eid == null) {
                eid = "";
            }
            pBStringField.set(eid);
            messageOuterClass$TimiEmoData.type.set(1);
            PBStringField pBStringField2 = messageOuterClass$TimiEmoData.url;
            String url = ((IFavoriteEmoticonInfo) kVar.getQqEmoInfo()).getUrl();
            if (url != null) {
                str = url;
            }
            pBStringField2.set(str);
        } else if (qqEmoInfo instanceof HotPicEmoInfo) {
            messageOuterClass$TimiEmoData.type.set(2);
            PBStringField pBStringField3 = messageOuterClass$TimiEmoData.url;
            String url2 = ((HotPicEmoInfo) kVar.getQqEmoInfo()).getUrl();
            if (url2 != null) {
                str = url2;
            }
            pBStringField3.set(str);
        } else if (qqEmoInfo instanceof IPicEmoticonInfo) {
            messageOuterClass$TimiEmoData.type.set(3);
            messageOuterClass$TimiEmoData.url.set("");
            if (((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon() != null) {
                String str2 = ((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon().epId;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String str3 = ((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon().eId;
                    if (str3 != null && str3.length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        messageOuterClass$TimiEmoData.epId.set(((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon().epId);
                        messageOuterClass$TimiEmoData.eId.set(((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon().eId);
                        MessageOuterClass$TimiPkgEmoticonData messageOuterClass$TimiPkgEmoticonData = messageOuterClass$TimiEmoData.pkgEmoData;
                        Emoticon emoticon = ((IPicEmoticonInfo) kVar.getQqEmoInfo()).getEmoticon();
                        Intrinsics.checkNotNullExpressionValue(emoticon, "qqEmoInfo.emoticon");
                        messageOuterClass$TimiPkgEmoticonData.set(l.e(emoticon, (IPicEmoticonInfo) kVar.getQqEmoInfo()));
                    }
                }
            }
            com.tencent.timi.game.utils.l.e("TimiEmoInfo", "bad IPicEmoticonInfo");
        }
        return messageOuterClass$TimiEmoData;
    }
}

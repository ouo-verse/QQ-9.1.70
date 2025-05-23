package xg4;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$TimiEmoData;
import trpc.yes.common.MessageOuterClass$TimiEmoMsg;
import trpc.yes.common.MessageOuterClass$TimiPkgEmoticonData;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\f"}, d2 = {"Ltrpc/yes/common/MessageOuterClass$TimiEmoMsg;", "", "b", "Ltrpc/yes/common/MessageOuterClass$TimiEmoData;", "a", "Ltrpc/yes/common/MessageOuterClass$TimiPkgEmoticonData;", "c", "Lcom/tencent/mobileqq/data/Emoticon;", "d", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "picInfo", "e", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class l {
    public static final boolean a(@NotNull MessageOuterClass$TimiEmoData messageOuterClass$TimiEmoData) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(messageOuterClass$TimiEmoData, "<this>");
        int i3 = messageOuterClass$TimiEmoData.type.get();
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return false;
            }
            String str = messageOuterClass$TimiEmoData.epId.get();
            Intrinsics.checkNotNullExpressionValue(str, "epId.get()");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            String str2 = messageOuterClass$TimiEmoData.eId.get();
            Intrinsics.checkNotNullExpressionValue(str2, "eId.get()");
            if (str2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
            MessageOuterClass$TimiPkgEmoticonData pkgEmoData = messageOuterClass$TimiEmoData.pkgEmoData;
            Intrinsics.checkNotNullExpressionValue(pkgEmoData, "pkgEmoData");
            if (!c(pkgEmoData)) {
                return false;
            }
            return true;
        }
        String str3 = messageOuterClass$TimiEmoData.url.get();
        Intrinsics.checkNotNullExpressionValue(str3, "url.get()");
        if (str3.length() <= 0) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull MessageOuterClass$TimiEmoMsg messageOuterClass$TimiEmoMsg) {
        Intrinsics.checkNotNullParameter(messageOuterClass$TimiEmoMsg, "<this>");
        MessageOuterClass$TimiEmoData msg_data = messageOuterClass$TimiEmoMsg.msg_data;
        Intrinsics.checkNotNullExpressionValue(msg_data, "msg_data");
        return a(msg_data);
    }

    public static final boolean c(@NotNull MessageOuterClass$TimiPkgEmoticonData messageOuterClass$TimiPkgEmoticonData) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(messageOuterClass$TimiPkgEmoticonData, "<this>");
        String str = messageOuterClass$TimiPkgEmoticonData.epId.get();
        Intrinsics.checkNotNullExpressionValue(str, "epId.get()");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = messageOuterClass$TimiPkgEmoticonData.eId.get();
            Intrinsics.checkNotNullExpressionValue(str2, "eId.get()");
            if (str2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Emoticon d(@NotNull MessageOuterClass$TimiPkgEmoticonData messageOuterClass$TimiPkgEmoticonData) {
        Intrinsics.checkNotNullParameter(messageOuterClass$TimiPkgEmoticonData, "<this>");
        Emoticon emoticon = new Emoticon();
        emoticon.epId = messageOuterClass$TimiPkgEmoticonData.epId.get();
        emoticon.eId = messageOuterClass$TimiPkgEmoticonData.eId.get();
        emoticon.name = messageOuterClass$TimiPkgEmoticonData.name.get();
        emoticon.encryptKey = messageOuterClass$TimiPkgEmoticonData.encryptKey.get();
        emoticon.isSound = messageOuterClass$TimiPkgEmoticonData.isSound.get();
        emoticon.width = messageOuterClass$TimiPkgEmoticonData.width.get();
        emoticon.height = messageOuterClass$TimiPkgEmoticonData.height.get();
        emoticon.jobType = messageOuterClass$TimiPkgEmoticonData.jobType.get();
        emoticon.keyword = messageOuterClass$TimiPkgEmoticonData.keyword.get();
        emoticon.keywords = messageOuterClass$TimiPkgEmoticonData.keywords.get();
        emoticon.character = messageOuterClass$TimiPkgEmoticonData.character.get();
        emoticon.extensionHeight = messageOuterClass$TimiPkgEmoticonData.extensionHeight.get();
        emoticon.extensionWidth = messageOuterClass$TimiPkgEmoticonData.extensionWidth.get();
        emoticon.isAPNG = messageOuterClass$TimiPkgEmoticonData.isAPNG.get();
        return emoticon;
    }

    @NotNull
    public static final MessageOuterClass$TimiPkgEmoticonData e(@NotNull Emoticon emoticon, @NotNull IPicEmoticonInfo picInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(emoticon, "<this>");
        Intrinsics.checkNotNullParameter(picInfo, "picInfo");
        MessageOuterClass$TimiPkgEmoticonData messageOuterClass$TimiPkgEmoticonData = new MessageOuterClass$TimiPkgEmoticonData();
        PBStringField pBStringField = messageOuterClass$TimiPkgEmoticonData.epId;
        String str = emoticon.epId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        PBStringField pBStringField2 = messageOuterClass$TimiPkgEmoticonData.eId;
        String str3 = emoticon.eId;
        if (str3 == null) {
            str3 = "";
        }
        pBStringField2.set(str3);
        PBStringField pBStringField3 = messageOuterClass$TimiPkgEmoticonData.name;
        String str4 = emoticon.name;
        if (str4 == null) {
            str4 = "";
        }
        pBStringField3.set(str4);
        PBStringField pBStringField4 = messageOuterClass$TimiPkgEmoticonData.encryptKey;
        String str5 = emoticon.encryptKey;
        if (str5 == null) {
            str5 = "";
        }
        pBStringField4.set(str5);
        messageOuterClass$TimiPkgEmoticonData.isSound.set(emoticon.isSound);
        messageOuterClass$TimiPkgEmoticonData.width.set(emoticon.width);
        messageOuterClass$TimiPkgEmoticonData.height.set(emoticon.height);
        messageOuterClass$TimiPkgEmoticonData.jobType.set(emoticon.jobType);
        PBStringField pBStringField5 = messageOuterClass$TimiPkgEmoticonData.keyword;
        String str6 = emoticon.keyword;
        if (str6 == null) {
            str6 = "";
        }
        pBStringField5.set(str6);
        PBStringField pBStringField6 = messageOuterClass$TimiPkgEmoticonData.keywords;
        String str7 = emoticon.keywords;
        if (str7 == null) {
            str7 = "";
        }
        pBStringField6.set(str7);
        PBStringField pBStringField7 = messageOuterClass$TimiPkgEmoticonData.character;
        String str8 = emoticon.character;
        if (str8 != null) {
            str2 = str8;
        }
        pBStringField7.set(str2);
        messageOuterClass$TimiPkgEmoticonData.extensionWidth.set(emoticon.extensionWidth);
        messageOuterClass$TimiPkgEmoticonData.extensionHeight.set(emoticon.extensionHeight);
        PBBoolField pBBoolField = messageOuterClass$TimiPkgEmoticonData.isAPNG;
        if (!emoticon.isAPNG && !picInfo.isAPNG()) {
            z16 = false;
        } else {
            z16 = true;
        }
        pBBoolField.set(z16);
        messageOuterClass$TimiPkgEmoticonData.imageType.set(picInfo.getImageType());
        return messageOuterClass$TimiPkgEmoticonData;
    }
}

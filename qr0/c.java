package qr0;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.LiveGiftElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TaskTopMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.kernel.nativeinterface.YoloGameResultElement;
import com.tencent.qqnt.kernel.nativeinterface.YoloGameUserInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.ProclamationElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.VASGiftSpendCoinItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006\u001a\u0012\u0010\t\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0001\u001a\u00020\n\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\f2\u0006\u0010\u0001\u001a\u00020\f\u001a\u0012\u0010\u000f\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u000e\u001a\u0012\u0010\u0011\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u0010\u001a\u0012\u0010\u0013\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0012\u001a\u0012\u0010\u0015\u001a\u00020\u0002*\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u0014\u001a\u0012\u0010\u0017\u001a\u00020\u0002*\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u0016\u001a\u0012\u0010\u0019\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u0018\u001a\u0012\u0010\u001b\u001a\u00020\u0002*\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u001a\u001a\u0012\u0010\u001d\u001a\u00020\u0002*\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u001c\u001a\u0012\u0010\u001f\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010\u0001\u001a\u00020\u001e\u001a\u0012\u0010!\u001a\u00020\u0002*\u00020 2\u0006\u0010\u0001\u001a\u00020 \u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\"2\u0006\u0010\u0001\u001a\u00020\"\u001a\u0012\u0010%\u001a\u00020\u0002*\u00020$2\u0006\u0010\u0001\u001a\u00020$\u001a\u0012\u0010'\u001a\u00020\u0002*\u00020&2\u0006\u0010\u0001\u001a\u00020&\u001a>\u0010-\u001a\u00020\u00022\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*\u001a\u0012\u0010/\u001a\u00020\u0002*\u00020.2\u0006\u0010\u0001\u001a\u00020.\u001a2\u00101\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u0002000(j\b\u0012\u0004\u0012\u000200`*2\u0016\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u0002000(j\b\u0012\u0004\u0012\u000200`*\u001a\u0012\u00103\u001a\u00020\u0002*\u0002022\u0006\u0010\u0001\u001a\u000202\u001a\u0012\u00105\u001a\u00020\u0002*\u0002042\u0006\u0010\u0001\u001a\u000204\u001a\u0012\u00107\u001a\u00020\u0002*\u0002062\u0006\u0010\u0001\u001a\u000206\u001a\u0014\u0010:\u001a\u00020\u0002*\u0002082\b\u0010\u0001\u001a\u0004\u0018\u000109\u001a\u0012\u0010=\u001a\u00020\u0002*\u00020;2\u0006\u0010<\u001a\u00020;\u001a\u0012\u0010?\u001a\u00020\u0002*\u00020>2\u0006\u0010\u0001\u001a\u00020>\u001a\u0012\u0010A\u001a\u00020\u0002*\u00020@2\u0006\u0010\u0001\u001a\u00020@\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020B2\u0006\u0010\u0001\u001a\u00020B\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "other", "", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "w", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "y", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/ProclamationElement;", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "v", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardRow;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "e", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "left", "right", "D", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/TextGiftElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/VASGiftSpendCoinItem;", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/LiveGiftElement;", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "otherEmojiLikes", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/YoloGameResultElement;", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/TaskTopMsgElement;", "o", "nt-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {
    public static final boolean A(@NotNull XmlElement xmlElement, @NotNull XmlElement other) {
        Intrinsics.checkNotNullParameter(xmlElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (xmlElement.busiType == other.busiType && xmlElement.busiId == other.busiId && xmlElement.ctrlFlag == other.ctrlFlag && Intrinsics.areEqual(xmlElement.content, other.content) && Intrinsics.areEqual(xmlElement.templId, other.templId) && Intrinsics.areEqual(xmlElement.seqId, other.seqId) && Intrinsics.areEqual(xmlElement.templParam, other.templParam) && Intrinsics.areEqual(xmlElement.pbReserv, other.pbReserv)) {
            return true;
        }
        return false;
    }

    public static final boolean B(@NotNull ArrayList<VASGiftSpendCoinItem> arrayList, @NotNull ArrayList<VASGiftSpendCoinItem> other) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (arrayList.size() == other.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Iterator<VASGiftSpendCoinItem> it = arrayList.iterator();
            while (it.hasNext()) {
                VASGiftSpendCoinItem next = it.next();
                Iterator<T> it5 = other.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        VASGiftSpendCoinItem vASGiftSpendCoinItem = (VASGiftSpendCoinItem) obj;
                        if (vASGiftSpendCoinItem.coinType == next.coinType && vASGiftSpendCoinItem.amt == next.amt) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj == null) {
                    return false;
                }
            }
        }
        return z16;
    }

    public static final boolean C(@NotNull LocalGrayTipElement localGrayTipElement, @NotNull LocalGrayTipElement other) {
        Intrinsics.checkNotNullParameter(localGrayTipElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (localGrayTipElement.type == other.type) {
            return true;
        }
        return false;
    }

    public static final boolean D(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        if (Intrinsics.areEqual(arrayList, arrayList2)) {
            return true;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return false;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(arrayList.get(i3), arrayList2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(@NotNull ArkElement arkElement, @NotNull ArkElement other) {
        Intrinsics.checkNotNullParameter(arkElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(arkElement.bytesData, other.bytesData);
    }

    public static final boolean b(@NotNull FaceElement faceElement, @NotNull FaceElement other) {
        Intrinsics.checkNotNullParameter(faceElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (faceElement.faceIndex == other.faceIndex && Intrinsics.areEqual(faceElement.faceText, other.faceText) && Intrinsics.areEqual(faceElement.resultId, other.resultId)) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull FileElement fileElement, @NotNull FileElement other) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(fileElement.fileMd5, other.fileMd5) && Intrinsics.areEqual(fileElement.fileName, other.fileName) && Intrinsics.areEqual(fileElement.filePath, other.filePath) && fileElement.fileSize == other.fileSize && Intrinsics.areEqual(fileElement.picHeight, other.picHeight) && Intrinsics.areEqual(fileElement.picWidth, other.picWidth) && Intrinsics.areEqual(fileElement.picThumbPath, other.picThumbPath) && Intrinsics.areEqual(fileElement.expireTime, other.expireTime) && Intrinsics.areEqual(fileElement.file10MMd5, other.file10MMd5) && Intrinsics.areEqual(fileElement.fileSha, other.fileSha) && Intrinsics.areEqual(fileElement.fileSha3, other.fileSha3) && Intrinsics.areEqual(fileElement.videoDuration, other.videoDuration) && Intrinsics.areEqual(fileElement.transferStatus, other.transferStatus) && Intrinsics.areEqual(fileElement.progress, other.progress) && Intrinsics.areEqual(fileElement.invalidState, other.invalidState)) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @NotNull FileTransNotifyInfo other) {
        Intrinsics.checkNotNullParameter(fileTransNotifyInfo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (fileTransNotifyInfo.fileModelId == other.fileModelId && fileTransNotifyInfo.msgElementId == other.msgElementId && fileTransNotifyInfo.msgId == other.msgId && fileTransNotifyInfo.fileProgress == other.fileProgress && fileTransNotifyInfo.fileSpeed == other.fileSpeed && fileTransNotifyInfo.fileErrCode == other.fileErrCode && Intrinsics.areEqual(fileTransNotifyInfo.fileErrMsg, other.fileErrMsg) && fileTransNotifyInfo.fileDownType == other.fileDownType && fileTransNotifyInfo.thumbSize == other.thumbSize && Intrinsics.areEqual(fileTransNotifyInfo.filePath, other.filePath) && fileTransNotifyInfo.totalSize == other.totalSize && fileTransNotifyInfo.trasferStatus == other.trasferStatus && fileTransNotifyInfo.step == other.step) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull InlineKeyboardButton inlineKeyboardButton, @NotNull InlineKeyboardButton other) {
        Intrinsics.checkNotNullParameter(inlineKeyboardButton, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(inlineKeyboardButton.f359191id, other.f359191id) && Intrinsics.areEqual(inlineKeyboardButton.label, other.label) && Intrinsics.areEqual(inlineKeyboardButton.visitedLabel, other.visitedLabel) && inlineKeyboardButton.style == other.style && inlineKeyboardButton.type == other.type && inlineKeyboardButton.clickLimit == other.clickLimit && Intrinsics.areEqual(inlineKeyboardButton.unsupportTips, other.unsupportTips) && Intrinsics.areEqual(inlineKeyboardButton.data, other.data) && inlineKeyboardButton.atBotShowChannelList == other.atBotShowChannelList && inlineKeyboardButton.permissionType == other.permissionType && D(inlineKeyboardButton.specifyRoleIds, other.specifyRoleIds) && D(inlineKeyboardButton.specifyTinyids, other.specifyTinyids)) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull InlineKeyboardElement inlineKeyboardElement, @NotNull InlineKeyboardElement other) {
        Intrinsics.checkNotNullParameter(inlineKeyboardElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        boolean areEqual = Intrinsics.areEqual(inlineKeyboardElement.rows, other.rows);
        ArrayList<InlineKeyboardRow> arrayList = inlineKeyboardElement.rows;
        if (arrayList != null && other.rows != null && arrayList.size() == other.rows.size()) {
            int size = inlineKeyboardElement.rows.size();
            for (int i3 = 0; i3 < size; i3++) {
                InlineKeyboardRow inlineKeyboardRow = inlineKeyboardElement.rows.get(i3);
                Intrinsics.checkNotNullExpressionValue(inlineKeyboardRow, "rows[index]");
                InlineKeyboardRow inlineKeyboardRow2 = other.rows.get(i3);
                Intrinsics.checkNotNullExpressionValue(inlineKeyboardRow2, "other.rows[index]");
                if (!g(inlineKeyboardRow, inlineKeyboardRow2)) {
                    return false;
                }
            }
            areEqual = true;
        }
        if (areEqual && inlineKeyboardElement.botAppid == other.botAppid) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull InlineKeyboardRow inlineKeyboardRow, @NotNull InlineKeyboardRow other) {
        Intrinsics.checkNotNullParameter(inlineKeyboardRow, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(inlineKeyboardRow.buttons, other.buttons)) {
            return true;
        }
        ArrayList<InlineKeyboardButton> arrayList = inlineKeyboardRow.buttons;
        if (arrayList == null || other.buttons == null || arrayList.size() != other.buttons.size()) {
            return false;
        }
        int size = inlineKeyboardRow.buttons.size();
        for (int i3 = 0; i3 < size; i3++) {
            InlineKeyboardButton inlineKeyboardButton = inlineKeyboardRow.buttons.get(i3);
            Intrinsics.checkNotNullExpressionValue(inlineKeyboardButton, "buttons[index]");
            InlineKeyboardButton inlineKeyboardButton2 = other.buttons.get(i3);
            Intrinsics.checkNotNullExpressionValue(inlineKeyboardButton2, "other.buttons[index]");
            if (!e(inlineKeyboardButton, inlineKeyboardButton2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean h(@NotNull LiveGiftElement liveGiftElement, @NotNull LiveGiftElement other) {
        Intrinsics.checkNotNullParameter(liveGiftElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(liveGiftElement.getKStrReceiverTinyId(), other.getKStrReceiverTinyId()) && liveGiftElement.getKUInt64GiftNum() == other.getKUInt64GiftNum() && liveGiftElement.getKUInt64GiftId() == other.getKUInt64GiftId() && Intrinsics.areEqual(liveGiftElement.getKStrGiftName(), other.getKStrGiftName())) {
            return true;
        }
        return false;
    }

    public static final boolean i(@NotNull MarkdownElement markdownElement, @NotNull MarkdownElement other) {
        Intrinsics.checkNotNullParameter(markdownElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(markdownElement.content, other.content);
    }

    public static final boolean j(@NotNull MarketFaceElement marketFaceElement, @NotNull MarketFaceElement other) {
        Intrinsics.checkNotNullParameter(marketFaceElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (marketFaceElement.itemType == other.itemType && marketFaceElement.faceInfo == other.faceInfo && marketFaceElement.emojiPackageId == other.emojiPackageId && marketFaceElement.subType == other.subType && marketFaceElement.mediaType == other.mediaType && marketFaceElement.imageWidth == other.imageWidth && marketFaceElement.imageHeight == other.imageHeight && Intrinsics.areEqual(marketFaceElement.faceName, other.faceName) && Intrinsics.areEqual(marketFaceElement.emojiId, other.emojiId) && Intrinsics.areEqual(marketFaceElement.key, other.key) && Intrinsics.areEqual(marketFaceElement.mobileParam, other.mobileParam) && Intrinsics.areEqual(marketFaceElement.sourceType, other.sourceType) && Intrinsics.areEqual(marketFaceElement.startTime, other.startTime) && Intrinsics.areEqual(marketFaceElement.endTime, other.endTime) && Intrinsics.areEqual(marketFaceElement.emojiType, other.emojiType) && Intrinsics.areEqual(marketFaceElement.hasIpProduct, other.hasIpProduct) && Intrinsics.areEqual(marketFaceElement.voiceItemHeightArr, other.voiceItemHeightArr) && Intrinsics.areEqual(marketFaceElement.sourceName, other.sourceName) && Intrinsics.areEqual(marketFaceElement.sourceJumpUrl, other.sourceJumpUrl) && Intrinsics.areEqual(marketFaceElement.sourceTypeName, other.sourceTypeName) && Intrinsics.areEqual(marketFaceElement.backColor, other.backColor) && Intrinsics.areEqual(marketFaceElement.volumeColor, other.volumeColor)) {
            return true;
        }
        return false;
    }

    public static final boolean k(@NotNull MsgElement msgElement, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (obj != null && (obj instanceof MsgElement)) {
            int i3 = msgElement.elementType;
            MsgElement msgElement2 = (MsgElement) obj;
            if (i3 == msgElement2.elementType && msgElement.elementId == msgElement2.elementId) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 14) {
                                if (i3 != 20) {
                                    if (i3 != 29) {
                                        if (i3 != 17) {
                                            if (i3 != 18) {
                                                switch (i3) {
                                                    case 5:
                                                        VideoElement videoElement = msgElement.videoElement;
                                                        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
                                                        VideoElement videoElement2 = msgElement2.videoElement;
                                                        Intrinsics.checkNotNullExpressionValue(videoElement2, "other.videoElement");
                                                        return q(videoElement, videoElement2);
                                                    case 6:
                                                        FaceElement faceElement = msgElement.faceElement;
                                                        Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                                                        FaceElement faceElement2 = msgElement2.faceElement;
                                                        Intrinsics.checkNotNullExpressionValue(faceElement2, "other.faceElement");
                                                        return b(faceElement, faceElement2);
                                                    case 7:
                                                        ReplyElement replyElement = msgElement.replyElement;
                                                        Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                                                        ReplyElement replyElement2 = msgElement2.replyElement;
                                                        Intrinsics.checkNotNullExpressionValue(replyElement2, "other.replyElement");
                                                        return n(replyElement, replyElement2);
                                                    case 8:
                                                        GrayTipElement grayTipElement = msgElement.grayTipElement;
                                                        Intrinsics.checkNotNullExpressionValue(grayTipElement, "grayTipElement");
                                                        GrayTipElement grayTipElement2 = msgElement2.grayTipElement;
                                                        Intrinsics.checkNotNullExpressionValue(grayTipElement2, "other.grayTipElement");
                                                        return w(grayTipElement, grayTipElement2);
                                                    case 9:
                                                        WalletElement walletElement = msgElement.walletElement;
                                                        Intrinsics.checkNotNullExpressionValue(walletElement, "walletElement");
                                                        WalletElement walletElement2 = msgElement2.walletElement;
                                                        Intrinsics.checkNotNullExpressionValue(walletElement2, "other.walletElement");
                                                        return s(walletElement, walletElement2);
                                                    case 10:
                                                        ArkElement arkElement = msgElement.arkElement;
                                                        Intrinsics.checkNotNullExpressionValue(arkElement, "arkElement");
                                                        ArkElement arkElement2 = msgElement2.arkElement;
                                                        Intrinsics.checkNotNullExpressionValue(arkElement2, "other.arkElement");
                                                        return a(arkElement, arkElement2);
                                                    case 11:
                                                        MarketFaceElement marketFaceElement = msgElement.marketFaceElement;
                                                        Intrinsics.checkNotNullExpressionValue(marketFaceElement, "marketFaceElement");
                                                        MarketFaceElement marketFaceElement2 = msgElement2.marketFaceElement;
                                                        Intrinsics.checkNotNullExpressionValue(marketFaceElement2, "other.marketFaceElement");
                                                        return j(marketFaceElement, marketFaceElement2);
                                                    case 12:
                                                        LiveGiftElement liveGiftElement = msgElement.liveGiftElement;
                                                        Intrinsics.checkNotNullExpressionValue(liveGiftElement, "liveGiftElement");
                                                        LiveGiftElement liveGiftElement2 = msgElement2.liveGiftElement;
                                                        Intrinsics.checkNotNullExpressionValue(liveGiftElement2, "other.liveGiftElement");
                                                        return h(liveGiftElement, liveGiftElement2);
                                                    default:
                                                        if (!((IAppSetting) QRoute.api(IAppSetting.class)).debug()) {
                                                            return Intrinsics.areEqual(msgElement, obj);
                                                        }
                                                        throw new Exception("undefined isSameContent() function for the element, elementType = " + msgElement.elementType);
                                                }
                                            }
                                            TextGiftElement textGiftElement = msgElement.textGiftElement;
                                            Intrinsics.checkNotNullExpressionValue(textGiftElement, "textGiftElement");
                                            TextGiftElement textGiftElement2 = msgElement2.textGiftElement;
                                            Intrinsics.checkNotNullExpressionValue(textGiftElement2, "other.textGiftElement");
                                            return z(textGiftElement, textGiftElement2);
                                        }
                                        InlineKeyboardElement inlineKeyboardElement = msgElement.inlineKeyboardElement;
                                        Intrinsics.checkNotNullExpressionValue(inlineKeyboardElement, "inlineKeyboardElement");
                                        InlineKeyboardElement inlineKeyboardElement2 = msgElement2.inlineKeyboardElement;
                                        Intrinsics.checkNotNullExpressionValue(inlineKeyboardElement2, "other.inlineKeyboardElement");
                                        return f(inlineKeyboardElement, inlineKeyboardElement2);
                                    }
                                    TaskTopMsgElement taskTopMsgElement = msgElement.taskTopMsgElement;
                                    Intrinsics.checkNotNullExpressionValue(taskTopMsgElement, "taskTopMsgElement");
                                    TaskTopMsgElement taskTopMsgElement2 = msgElement2.taskTopMsgElement;
                                    Intrinsics.checkNotNullExpressionValue(taskTopMsgElement2, "other.taskTopMsgElement");
                                    return o(taskTopMsgElement, taskTopMsgElement2);
                                }
                                YoloGameResultElement yoloGameResultElement = msgElement.yoloGameResultElement;
                                Intrinsics.checkNotNullExpressionValue(yoloGameResultElement, "yoloGameResultElement");
                                YoloGameResultElement yoloGameResultElement2 = msgElement2.yoloGameResultElement;
                                Intrinsics.checkNotNullExpressionValue(yoloGameResultElement2, "other.yoloGameResultElement");
                                return t(yoloGameResultElement, yoloGameResultElement2);
                            }
                            MarkdownElement markdownElement = msgElement.markdownElement;
                            Intrinsics.checkNotNullExpressionValue(markdownElement, "markdownElement");
                            MarkdownElement markdownElement2 = msgElement2.markdownElement;
                            Intrinsics.checkNotNullExpressionValue(markdownElement2, "other.markdownElement");
                            return i(markdownElement, markdownElement2);
                        }
                        FileElement fileElement = msgElement.fileElement;
                        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
                        FileElement fileElement2 = msgElement2.fileElement;
                        Intrinsics.checkNotNullExpressionValue(fileElement2, "other.fileElement");
                        return c(fileElement, fileElement2);
                    }
                    PicElement picElement = msgElement.picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                    PicElement picElement2 = msgElement2.picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement2, "other.picElement");
                    return m(picElement, picElement2);
                }
                TextElement textElement = msgElement.textElement;
                Intrinsics.checkNotNullExpressionValue(textElement, "textElement");
                TextElement textElement2 = msgElement2.textElement;
                Intrinsics.checkNotNullExpressionValue(textElement2, "other.textElement");
                return p(textElement, textElement2);
            }
        }
        return false;
    }

    public static final boolean l(@NotNull MsgEmojiLikes msgEmojiLikes, @NotNull MsgEmojiLikes otherEmojiLikes) {
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        Intrinsics.checkNotNullParameter(otherEmojiLikes, "otherEmojiLikes");
        if (Intrinsics.areEqual(msgEmojiLikes.emojiId, otherEmojiLikes.emojiId) && msgEmojiLikes.emojiType == otherEmojiLikes.emojiType && msgEmojiLikes.likesCnt == otherEmojiLikes.likesCnt && msgEmojiLikes.isClicked == otherEmojiLikes.isClicked) {
            return true;
        }
        return false;
    }

    public static final boolean m(@NotNull PicElement picElement, @NotNull PicElement other) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (picElement.picSubType == other.picSubType && Intrinsics.areEqual(picElement.fileName, other.fileName) && picElement.fileSize == other.fileSize && picElement.picWidth == other.picWidth && picElement.picHeight == other.picHeight && picElement.original == other.original && Intrinsics.areEqual(picElement.md5HexStr, other.md5HexStr) && Intrinsics.areEqual(picElement.sourcePath, other.sourcePath) && Intrinsics.areEqual(picElement.thumbPath, other.thumbPath) && Intrinsics.areEqual(picElement.transferStatus, other.transferStatus) && Intrinsics.areEqual(picElement.progress, other.progress) && Intrinsics.areEqual(picElement.picType, other.picType) && Intrinsics.areEqual(picElement.invalidState, other.invalidState)) {
            return true;
        }
        return false;
    }

    public static final boolean n(@NotNull ReplyElement replyElement, @NotNull ReplyElement other) {
        Intrinsics.checkNotNullParameter(replyElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (replyElement.replayMsgId == other.replayMsgId && Intrinsics.areEqual(replyElement.replayMsgSeq, other.replayMsgSeq) && Intrinsics.areEqual(replyElement.sourceMsgText, other.sourceMsgText) && Intrinsics.areEqual(replyElement.senderUid, other.senderUid) && Intrinsics.areEqual(replyElement.replyMsgClientSeq, other.replyMsgClientSeq) && Intrinsics.areEqual(replyElement.replyMsgTime, other.replyMsgTime) && Intrinsics.areEqual(replyElement.replayMsgRootCommentCnt, other.replayMsgRootCommentCnt) && replyElement.replyMsgRevokeType == other.replyMsgRevokeType) {
            return true;
        }
        return false;
    }

    public static final boolean o(@NotNull TaskTopMsgElement taskTopMsgElement, @NotNull TaskTopMsgElement other) {
        Intrinsics.checkNotNullParameter(taskTopMsgElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(taskTopMsgElement.msgTitle, other.msgTitle) && Intrinsics.areEqual(taskTopMsgElement.msgSummary, other.msgSummary) && Intrinsics.areEqual(taskTopMsgElement.iconUrl, other.iconUrl)) {
            return true;
        }
        return false;
    }

    public static final boolean p(@NotNull TextElement textElement, @NotNull TextElement other) {
        Intrinsics.checkNotNullParameter(textElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(textElement.content, other.content) && textElement.atType == other.atType && textElement.atUid == other.atUid && textElement.atTinyId == other.atTinyId && Intrinsics.areEqual(textElement.atNtUid, other.atNtUid) && Intrinsics.areEqual(textElement.subElementType, other.subElementType) && Intrinsics.areEqual(textElement.atChannelId, other.atChannelId)) {
            return true;
        }
        return false;
    }

    public static final boolean q(@NotNull VideoElement videoElement, @NotNull VideoElement other) {
        Intrinsics.checkNotNullParameter(videoElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(videoElement.filePath, other.filePath) && Intrinsics.areEqual(videoElement.fileName, other.fileName) && Intrinsics.areEqual(videoElement.videoMd5, other.videoMd5) && Intrinsics.areEqual(videoElement.thumbMd5, other.thumbMd5) && videoElement.fileTime == other.fileTime && videoElement.thumbSize == other.thumbSize && videoElement.fileFormat == other.fileFormat && videoElement.fileSize == other.fileSize && videoElement.thumbWidth == other.thumbWidth && videoElement.thumbHeight == other.thumbHeight && videoElement.busiType == other.busiType && Intrinsics.areEqual(videoElement.thumbPath, other.thumbPath) && Intrinsics.areEqual(videoElement.transferStatus, other.transferStatus) && Intrinsics.areEqual(videoElement.progress, other.progress) && Intrinsics.areEqual(videoElement.invalidState, other.invalidState)) {
            return true;
        }
        return false;
    }

    public static final boolean r(@NotNull WalletAio walletAio, @NotNull WalletAio other) {
        Intrinsics.checkNotNullParameter(walletAio, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (walletAio.background == other.background && walletAio.icon == other.icon && Intrinsics.areEqual(walletAio.title, other.title) && Intrinsics.areEqual(walletAio.subTitle, other.subTitle) && Intrinsics.areEqual(walletAio.content, other.content) && Intrinsics.areEqual(walletAio.notice, other.notice) && walletAio.titleColor == other.titleColor && walletAio.subtitleColor == other.subtitleColor && Intrinsics.areEqual(walletAio.actionsPriority, other.actionsPriority) && Intrinsics.areEqual(walletAio.nativeAndroid, other.nativeAndroid) && Intrinsics.areEqual(walletAio.pbReserve, other.pbReserve)) {
            return true;
        }
        return false;
    }

    public static final boolean s(@NotNull WalletElement walletElement, @NotNull WalletElement other) {
        Intrinsics.checkNotNullParameter(walletElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (walletElement.sendUin == other.sendUin && walletElement.channelId == other.channelId) {
            WalletAio receiver = walletElement.receiver;
            Intrinsics.checkNotNullExpressionValue(receiver, "receiver");
            WalletAio walletAio = other.receiver;
            Intrinsics.checkNotNullExpressionValue(walletAio, "other.receiver");
            if (r(receiver, walletAio) && walletElement.templateId == other.templateId && walletElement.resend == other.resend && walletElement.msgPriority == other.msgPriority && walletElement.redType == other.redType && Intrinsics.areEqual(walletElement.billNo, other.billNo) && Intrinsics.areEqual(walletElement.authkey, other.authkey) && walletElement.msgType == other.msgType && walletElement.redChannel == other.redChannel && Intrinsics.areEqual(walletElement.grapUin, other.grapUin)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean t(@NotNull YoloGameResultElement yoloGameResultElement, @NotNull YoloGameResultElement other) {
        Object firstOrNull;
        String str;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(yoloGameResultElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (yoloGameResultElement.userInfo.size() == other.userInfo.size()) {
            ArrayList<YoloGameUserInfo> userInfo = yoloGameResultElement.userInfo;
            Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) userInfo);
            YoloGameUserInfo yoloGameUserInfo = (YoloGameUserInfo) firstOrNull;
            String str2 = null;
            if (yoloGameUserInfo != null) {
                str = yoloGameUserInfo.bizId;
            } else {
                str = null;
            }
            ArrayList<YoloGameUserInfo> arrayList = other.userInfo;
            Intrinsics.checkNotNullExpressionValue(arrayList, "other.userInfo");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            YoloGameUserInfo yoloGameUserInfo2 = (YoloGameUserInfo) firstOrNull2;
            if (yoloGameUserInfo2 != null) {
                str2 = yoloGameUserInfo2.bizId;
            }
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean u(@NotNull EmojiReplyElement emojiReplyElement, @NotNull EmojiReplyElement other) {
        Intrinsics.checkNotNullParameter(emojiReplyElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (emojiReplyElement.tinyId == other.tinyId && emojiReplyElement.msgId == other.msgId && emojiReplyElement.msgSeq == other.msgSeq && emojiReplyElement.emojiId == other.emojiId && emojiReplyElement.emojiType == other.emojiType) {
            return true;
        }
        return false;
    }

    public static final boolean v(@NotNull EssenceElement essenceElement, @NotNull EssenceElement other) {
        Intrinsics.checkNotNullParameter(essenceElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (essenceElement.tinyId == other.tinyId && essenceElement.msgSeq == other.msgSeq && essenceElement.isSetEssence == other.isSetEssence) {
            return true;
        }
        return false;
    }

    public static final boolean w(@NotNull GrayTipElement grayTipElement, @NotNull GrayTipElement other) {
        Intrinsics.checkNotNullParameter(grayTipElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = grayTipElement.subElementType;
        if (i3 != other.subElementType) {
            return false;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 7) {
                        if (i3 != 12) {
                            if (i3 != 13) {
                                if (!((IAppSetting) QRoute.api(IAppSetting.class)).debug()) {
                                    return Intrinsics.areEqual(grayTipElement, other);
                                }
                                throw new Exception("undefined isSameContent() function for the element, subElementType = " + grayTipElement.subElementType);
                            }
                            LocalGrayTipElement localGrayTipElement = grayTipElement.localGrayTipElement;
                            Intrinsics.checkNotNullExpressionValue(localGrayTipElement, "localGrayTipElement");
                            LocalGrayTipElement localGrayTipElement2 = other.localGrayTipElement;
                            Intrinsics.checkNotNullExpressionValue(localGrayTipElement2, "other.localGrayTipElement");
                            return C(localGrayTipElement, localGrayTipElement2);
                        }
                        XmlElement xmlElement = grayTipElement.xmlElement;
                        Intrinsics.checkNotNullExpressionValue(xmlElement, "xmlElement");
                        XmlElement xmlElement2 = other.xmlElement;
                        Intrinsics.checkNotNullExpressionValue(xmlElement2, "other.xmlElement");
                        return A(xmlElement, xmlElement2);
                    }
                    EssenceElement essenceElement = grayTipElement.essenceElement;
                    Intrinsics.checkNotNullExpressionValue(essenceElement, "essenceElement");
                    EssenceElement essenceElement2 = other.essenceElement;
                    Intrinsics.checkNotNullExpressionValue(essenceElement2, "other.essenceElement");
                    return v(essenceElement, essenceElement2);
                }
                EmojiReplyElement emojiReplyElement = grayTipElement.emojiReplyElement;
                Intrinsics.checkNotNullExpressionValue(emojiReplyElement, "emojiReplyElement");
                EmojiReplyElement emojiReplyElement2 = other.emojiReplyElement;
                Intrinsics.checkNotNullExpressionValue(emojiReplyElement2, "other.emojiReplyElement");
                return u(emojiReplyElement, emojiReplyElement2);
            }
            ProclamationElement proclamationElement = grayTipElement.proclamationElement;
            Intrinsics.checkNotNullExpressionValue(proclamationElement, "proclamationElement");
            ProclamationElement proclamationElement2 = other.proclamationElement;
            Intrinsics.checkNotNullExpressionValue(proclamationElement2, "other.proclamationElement");
            return x(proclamationElement, proclamationElement2);
        }
        RevokeElement revokeElement = grayTipElement.revokeElement;
        Intrinsics.checkNotNullExpressionValue(revokeElement, "revokeElement");
        RevokeElement revokeElement2 = other.revokeElement;
        Intrinsics.checkNotNullExpressionValue(revokeElement2, "other.revokeElement");
        return y(revokeElement, revokeElement2);
    }

    public static final boolean x(@NotNull ProclamationElement proclamationElement, @NotNull ProclamationElement other) {
        Intrinsics.checkNotNullParameter(proclamationElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (proclamationElement.isSetProclamation == other.isSetProclamation) {
            return true;
        }
        return false;
    }

    public static final boolean y(@NotNull RevokeElement revokeElement, @NotNull RevokeElement other) {
        Intrinsics.checkNotNullParameter(revokeElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (revokeElement.operatorTinyId == other.operatorTinyId && revokeElement.operatorRole == other.operatorRole && Intrinsics.areEqual(revokeElement.operatorUid, other.operatorUid) && Intrinsics.areEqual(revokeElement.operatorNick, other.operatorNick) && Intrinsics.areEqual(revokeElement.operatorRemark, other.operatorRemark) && Intrinsics.areEqual(revokeElement.operatorMemRemark, other.operatorMemRemark) && Intrinsics.areEqual(revokeElement.origMsgSenderUid, other.origMsgSenderUid) && revokeElement.isSelfOperate == other.isSelfOperate) {
            return true;
        }
        return false;
    }

    public static final boolean z(@NotNull TextGiftElement textGiftElement, @NotNull TextGiftElement other) {
        Intrinsics.checkNotNullParameter(textGiftElement, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (textGiftElement.giftId == other.giftId && Intrinsics.areEqual(textGiftElement.giftName, other.giftName) && textGiftElement.receiverUin == other.receiverUin && textGiftElement.senderUin == other.senderUin && Intrinsics.areEqual(textGiftElement.receiverNick, other.receiverNick) && Intrinsics.areEqual(textGiftElement.senderNick, other.senderNick) && textGiftElement.price == other.price && Intrinsics.areEqual(textGiftElement.orderId, other.orderId) && Intrinsics.areEqual(textGiftElement.bgImageUrl, other.bgImageUrl) && textGiftElement.tianquanId == other.tianquanId && textGiftElement.level == other.level && Intrinsics.areEqual(textGiftElement.paddingTop, other.paddingTop)) {
            ArrayList<VASGiftSpendCoinItem> spendCoins = textGiftElement.spendCoins;
            Intrinsics.checkNotNullExpressionValue(spendCoins, "spendCoins");
            ArrayList<VASGiftSpendCoinItem> arrayList = other.spendCoins;
            Intrinsics.checkNotNullExpressionValue(arrayList, "other.spendCoins");
            if (B(spendCoins, arrayList) && textGiftElement.needPlayAnimation == other.needPlayAnimation) {
                return true;
            }
        }
        return false;
    }
}

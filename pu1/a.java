package pu1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.service.message.p;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements IRichTextAndMsgViaProvider {
    public void b(im_msg_body$RichText im_msg_body_richtext) {
        if (im_msg_body_richtext.elems.size() <= 0) {
            return;
        }
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
        generalflags_resvattr.uint32_compound_msg_flag.set(1);
        im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.general_flags.set(im_msg_body_generalflags);
        im_msg_body_richtext.elems.get().add(im_msg_body_elem);
    }

    boolean d(MessageForMixedMsg messageForMixedMsg) {
        int size = messageForMixedMsg.msgElemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (messageForMixedMsg.msgElemList.get(i3) instanceof MessageForShortVideo) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider
    public Object[] getRichTextAndMsgViaFromMessageRecord(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
        if (messageRecord.msgtype == -1035 && messageRecord.istroop == 10014) {
            im_msg_body_richtext = c((MessageForMixedMsg) messageRecord);
        }
        return new Object[]{im_msg_body_richtext, Integer.valueOf(i3)};
    }

    private void a(MessageForMixedMsg messageForMixedMsg, boolean z16, MessageRecord messageRecord) {
        if (z16) {
            String extInfoFromExtStr = messageForMixedMsg.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
            if (TextUtils.isEmpty(extInfoFromExtStr)) {
                return;
            }
            messageRecord.atInfoList = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr);
        }
    }

    public im_msg_body$RichText c(MessageForMixedMsg messageForMixedMsg) {
        im_msg_body$RichText z16;
        if (messageForMixedMsg == null) {
            return null;
        }
        boolean d16 = d(messageForMixedMsg);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        int size = messageForMixedMsg.msgElemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(i3);
            if (messageRecord instanceof MessageForText) {
                a(messageForMixedMsg, d16, messageRecord);
                im_msg_body$RichText A = p.A((MessageForText) messageRecord);
                if (A == null) {
                    return null;
                }
                for (int i16 = 0; i16 < A.elems.size(); i16++) {
                    im_msg_body_richtext.elems.add(A.elems.get(i16));
                }
            } else if (messageRecord instanceof MessageForPic) {
                im_msg_body$RichText im_msg_body_richtext2 = ((MessageForPic) messageRecord).richText;
                if (im_msg_body_richtext2 == null) {
                    return null;
                }
                im_msg_body_richtext.elems.add(im_msg_body_richtext2.elems.get(0));
            } else if (messageRecord instanceof MessageForShortVideo) {
                im_msg_body$RichText im_msg_body_richtext3 = ((MessageForShortVideo) messageRecord).richText;
                if (im_msg_body_richtext3 == null) {
                    return null;
                }
                for (int i17 = 0; i17 < im_msg_body_richtext3.elems.size(); i17++) {
                    im_msg_body$Elem im_msg_body_elem = im_msg_body_richtext3.elems.get(i17);
                    if (im_msg_body_elem.video_file.has()) {
                        im_msg_body_richtext.elems.add(im_msg_body_elem);
                    }
                }
            } else if ((messageRecord instanceof MessageForReplyText) && (z16 = p.z((MessageForReplyText) messageRecord)) != null) {
                for (int i18 = 0; i18 < z16.elems.size(); i18++) {
                    im_msg_body_richtext.elems.add(z16.elems.get(i18));
                }
            }
        }
        b(im_msg_body_richtext);
        return im_msg_body_richtext;
    }
}

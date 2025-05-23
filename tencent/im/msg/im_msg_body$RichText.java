package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$RichText extends MessageMicro<im_msg_body$RichText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"attr", "elems", "not_online_file", "ptt", "tmp_ptt", "trans_211_tmp_msg"}, new Object[]{null, null, null, null, null, null}, im_msg_body$RichText.class);
    public im_msg_body$Attr attr = new im_msg_body$Attr();
    public final PBRepeatMessageField<im_msg_body$Elem> elems = PBField.initRepeatMessage(im_msg_body$Elem.class);
    public im_msg_body$NotOnlineFile not_online_file = new im_msg_body$NotOnlineFile();
    public im_msg_body$Ptt ptt = new im_msg_body$Ptt();
    public im_msg_body$TmpPtt tmp_ptt = new im_msg_body$TmpPtt();
    public im_msg_body$Trans211TmpMsg trans_211_tmp_msg = new im_msg_body$Trans211TmpMsg();
}

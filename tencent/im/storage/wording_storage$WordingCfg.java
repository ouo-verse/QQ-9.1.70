package tencent.im.storage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class wording_storage$WordingCfg extends MessageMicro<wording_storage$WordingCfg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"auto_reply_flag", "select_id", "wording_list"}, new Object[]{0, 0, null}, wording_storage$WordingCfg.class);
    public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
    public final PBUInt32Field select_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<im_msg_body$RichText> wording_list = PBField.initRepeatMessage(im_msg_body$RichText.class);
}

package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$NotOnlineImage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype3 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype3> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"flash_troop_pic", "flash_c2c_pic"}, new Object[]{null, null}, hummer_commelem$MsgElemInfo_servtype3.class);
    public im_msg_body$CustomFace flash_troop_pic = new im_msg_body$CustomFace();
    public im_msg_body$NotOnlineImage flash_c2c_pic = new im_msg_body$NotOnlineImage();
}

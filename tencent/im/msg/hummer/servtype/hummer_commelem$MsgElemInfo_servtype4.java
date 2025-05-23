package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype4 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype4> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 34}, new String[]{"uint32_imsg_type", "st_story_aio_obj_msg"}, new Object[]{0, null}, hummer_commelem$MsgElemInfo_servtype4.class);
    public final PBUInt32Field uint32_imsg_type = PBField.initUInt32(0);
    public hummer_commelem$StoryAioObjMsg st_story_aio_obj_msg = new MessageMicro<hummer_commelem$StoryAioObjMsg>() { // from class: tencent.im.msg.hummer.servtype.hummer_commelem$StoryAioObjMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_ui_url", "str_jmp_url"}, new Object[]{"", ""}, hummer_commelem$StoryAioObjMsg.class);
        public final PBStringField str_ui_url = PBField.initString("");
        public final PBStringField str_jmp_url = PBField.initString("");
    };
}

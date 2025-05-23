package tencent.im.group_pro_proto.oidb0xf9c;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class discovery$Reply extends MessageMicro<discovery$Reply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"categories", "guilds"}, new Object[]{null, null}, discovery$Reply.class);
    public final PBRepeatMessageField<common$Category> categories = PBField.initRepeatMessage(common$Category.class);
    public common$Guilds guilds = new MessageMicro<common$Guilds>() { // from class: tencent.im.group_pro_proto.oidb0xf9c.common$Guilds
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{PictureConst.KEY_CATEGORY_ID, "guilds"}, new Object[]{0, null}, common$Guilds.class);
        public final PBUInt32Field category_id = PBField.initUInt32(0);
        public final PBRepeatMessageField<common$Guild> guilds = PBField.initRepeatMessage(common$Guild.class);
    };
}

package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class ExtBufForUI$ZPlan extends MessageMicro<ExtBufForUI$ZPlan> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"aio_head_effect_msg_flag", "recent_list_head_effect_msg_flag"}, new Object[]{0, 0}, ExtBufForUI$ZPlan.class);
    public final PBInt32Field aio_head_effect_msg_flag = PBField.initInt32(0);
    public final PBInt32Field recent_list_head_effect_msg_flag = PBField.initInt32(0);
}

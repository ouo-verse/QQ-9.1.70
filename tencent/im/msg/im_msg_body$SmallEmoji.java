package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$SmallEmoji extends MessageMicro<im_msg_body$SmallEmoji> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"packIdSum", NodeProps.CUSTOM_PROP_IMAGE_TYPE}, new Object[]{0, 0}, im_msg_body$SmallEmoji.class);
    public final PBUInt32Field packIdSum = PBField.initUInt32(0);
    public final PBUInt32Field imageType = PBField.initUInt32(0);
}

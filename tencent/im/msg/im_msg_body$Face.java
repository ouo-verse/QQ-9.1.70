package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$Face extends MessageMicro<im_msg_body$Face> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buf;
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBBytesField old;

    static {
        String[] strArr = {"index", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "buf"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 90}, strArr, new Object[]{0, byteStringMicro, byteStringMicro}, im_msg_body$Face.class);
    }

    public im_msg_body$Face() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.old = PBField.initBytes(byteStringMicro);
        this.buf = PBField.initBytes(byteStringMicro);
    }
}

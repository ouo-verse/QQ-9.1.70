package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_c2c_searcher$RspBody extends MessageMicro<oidb_c2c_searcher$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> msgs;
    public final PBRepeatField<ByteStringMicro> segs;
    public final PBEnumField result = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_c2c_searcher$Iterator> friends = PBField.initRepeatMessage(oidb_c2c_searcher$Iterator.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"result", "friends", "msgs", "segs"}, new Object[]{0, null, byteStringMicro, byteStringMicro}, oidb_c2c_searcher$RspBody.class);
    }

    public oidb_c2c_searcher$RspBody() {
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.msgs = PBField.initRepeat(pBBytesField);
        this.segs = PBField.initRepeat(pBBytesField);
    }
}

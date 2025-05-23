package tencent.im.oidb.cmd0xded;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xded$ClassifyInfo extends MessageMicro<oidb_0xded$ClassifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField color;
    public final PBBytesField icon_hover_url;
    public final PBBytesField icon_url;
    public oidb_0xded$Node node = new MessageMicro<oidb_0xded$Node>() { // from class: tencent.im.oidb.cmd0xded.oidb_0xded$Node
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field default_classify;

        /* renamed from: gc, reason: collision with root package name */
        public final PBRepeatField<Long> f435993gc;
        public final PBBytesField item;
        public final PBBytesField keyword;
        public final PBBytesField rule;
        public final PBUInt32Field type;

        static {
            String[] strArr = {PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "keyword", "type", "default_classify", TransferConfig.ExtendParamFloats.KEY_RULE, "gc"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L}, oidb_0xded$Node.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.item = PBField.initBytes(byteStringMicro);
            this.keyword = PBField.initBytes(byteStringMicro);
            this.type = PBField.initUInt32(0);
            this.default_classify = PBField.initUInt32(0);
            this.rule = PBField.initBytes(byteStringMicro);
            this.f435993gc = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        }
    };
    public final PBRepeatMessageField<oidb_0xded$Node> second_class = PBField.initRepeatMessage(oidb_0xded$Node.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"node", "second_class", "icon_url", "icon_hover_url", "color"}, new Object[]{null, null, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xded$ClassifyInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tencent.im.oidb.cmd0xded.oidb_0xded$Node] */
    public oidb_0xded$ClassifyInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.icon_url = PBField.initBytes(byteStringMicro);
        this.icon_hover_url = PBField.initBytes(byteStringMicro);
        this.color = PBField.initBytes(byteStringMicro);
    }
}

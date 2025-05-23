package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8b$ReqBody extends MessageMicro<oidb_cmd0xf8b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tweet"}, new Object[]{null}, oidb_cmd0xf8b$ReqBody.class);
    public oidb_cmd0xf8b$TweetInfo tweet = new MessageMicro<oidb_cmd0xf8b$TweetInfo>() { // from class: tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b$TweetInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_position;
        public final PBBytesField text;
        public oidb_cmd0xf8b$BiuMultiLevel biu_multi_level = new MessageMicro<oidb_cmd0xf8b$BiuMultiLevel>() { // from class: tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b$BiuMultiLevel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_biu_mutli_level"}, new Object[]{null}, oidb_cmd0xf8b$BiuMultiLevel.class);
            public final PBRepeatMessageField<oidb_cmd0xf8b$BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0xf8b$BiuOneLevelItem.class);
        };
        public final PBRepeatMessageField<oidb_cmd0xf8b$Picture> pictures = PBField.initRepeatMessage(oidb_cmd0xf8b$Picture.class);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"biu_multi_level", "pictures", "bytes_position", "text"}, new Object[]{null, null, byteStringMicro, byteStringMicro}, oidb_cmd0xf8b$TweetInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b$BiuMultiLevel] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_position = PBField.initBytes(byteStringMicro);
            this.text = PBField.initBytes(byteStringMicro);
        }
    };
}

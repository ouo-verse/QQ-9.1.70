package tencent.im.msg.hummer.servtype;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype45 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype45> {
    public static final int MdExtType_DEFAULT = 0;
    public static final int MdExtType_Flash_Transfer = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_markdown;
    public final PBBytesField bytes_md_ext;
    public final PBBytesField bytes_token;
    public final PBEnumField md_ext_type;
    public final PBBytesField md_summary;
    public final PBBytesField process_msg;
    public MarkdownStyle style;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MarkdownStyle extends MessageMicro<MarkdownStyle> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field bubble_type;
        public final PBBytesField layout;
        public final PBBytesField main_font_size;

        static {
            String[] strArr = {"main_font_size", TtmlNode.TAG_LAYOUT, "bubble_type"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0}, MarkdownStyle.class);
        }

        public MarkdownStyle() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.main_font_size = PBField.initBytes(byteStringMicro);
            this.layout = PBField.initBytes(byteStringMicro);
            this.bubble_type = PBField.initUInt32(0);
        }
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"bytes_markdown", "bytes_token", "style", "process_msg", "md_summary", "md_ext_type", "bytes_md_ext"}, new Object[]{byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype45.class);
    }

    public hummer_commelem$MsgElemInfo_servtype45() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_markdown = PBField.initBytes(byteStringMicro);
        this.bytes_token = PBField.initBytes(byteStringMicro);
        this.style = new MarkdownStyle();
        this.process_msg = PBField.initBytes(byteStringMicro);
        this.md_summary = PBField.initBytes(byteStringMicro);
        this.md_ext_type = PBField.initEnum(0);
        this.bytes_md_ext = PBField.initBytes(byteStringMicro);
    }
}

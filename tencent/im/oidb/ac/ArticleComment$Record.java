package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$Record extends MessageMicro<ArticleComment$Record> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField brief;
    public final PBBytesField name;
    public final PBBytesField puin;

    static {
        String[] strArr = {IPublicAccountBrowser.KEY_PUB_UIN, "name", "brief"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, ArticleComment$Record.class);
    }

    public ArticleComment$Record() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.puin = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.brief = PBField.initBytes(byteStringMicro);
    }
}

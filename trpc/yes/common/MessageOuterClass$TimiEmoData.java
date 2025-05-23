package trpc.yes.common;

import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$TimiEmoData extends MessageMicro<MessageOuterClass$TimiEmoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "url", EmojiManagerServiceProxy.EPID, "eId", "pkgEmoData"}, new Object[]{0, "", "", "", null}, MessageOuterClass$TimiEmoData.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField epId = PBField.initString("");
    public final PBStringField eId = PBField.initString("");
    public MessageOuterClass$TimiPkgEmoticonData pkgEmoData = new MessageOuterClass$TimiPkgEmoticonData();
}

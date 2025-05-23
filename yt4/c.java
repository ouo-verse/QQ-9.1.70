package yt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {
    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag;
        do {
            readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
        } while (storeUnknownField(codedInputByteBufferNano, readTag));
        return this;
    }

    public c a() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
